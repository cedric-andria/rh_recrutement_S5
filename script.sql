-- Table Responsable_service (Jérémie) : misy FK Service sy identifiant de connexion
create table responsable (
    id serial primary key,
    nom varchar not null,
    mdp varchar not null
);

create table service (
    id serial primary key,
    nom varchar not null
);

CREATE TABLE besoin_service (
    ID SERIAL PRIMARY KEY,
    ID_SERVICE INTEGER,
    ID_POSTE INTEGER,
    nbr INTEGER not null,
    VOLUME_HORAIRE DOUBLE PRECISION not null ,
    FOREIGN KEY (ID_SERVICE) REFERENCES service (ID),
    foreign key (ID_POSTE) references poste(id)
);

create table responsable_service (
  id serial primary key,
  id_service integer,
  id_responsable integer,
  foreign key (id_service) references service (id),
  foreign key (id_responsable) references responsable (id)
);

CREATE TABLE postulant (
   ID SERIAL PRIMARY KEY,
   NOM VARCHAR,
   PRENOM VARCHAR,
   DATE_NAISSANCE DATE,
   sexe integer check (0<= postulant.sexe <= 1 ),
   MAIL VARCHAR(100),
   MDP VARCHAR(50)
);
-- CritèresPoste (Jérémie) : misy FK Poste
CREATE TABLE poste (
    ID SERIAL PRIMARY KEY,
    NOM VARCHAR not null ,
    ID_SERVICE INTEGER,
    FOREIGN KEY (ID_SERVICE) REFERENCES service (ID)
);

create table diplome (
    id serial primary key,
    nom varchar not null
);

create table langue (
    id serial primary key,
    nom varchar not null
);

create table experience (
  id serial primary key,
  debut integer not null,
  fin integer not null
);

create table critere_poste (
    id serial primary key,
    id_poste integer,
    id_diplome integer,
    id_langue integer,
    id_experience integer,
    sexe integer not null check (0 <= critere_poste.sexe <=1),
    foreign key (id_poste) references poste (id),
    foreign key (id_diplome) references diplome (id),
    foreign key (id_langue) references langue (id),
    foreign key (id_experience) references experience (id)
);

-- V_note_CV (Jérémie) : vue mampiseo ny id_CV sy ilay id_Poste ary ireo notes mifanaraka aminy par rapport amin'ilay
-- critères, ohatrany, raha ny tena mety dia sady tonga dia triena par notes
create table coeff_diplome_service (
    id serial primary key,
    id_poste integer,
    id_diplome integer,
    note double precision not null,
    foreign key (id_poste) references poste (id),
    foreign key (id_diplome) references diplome (id)
);

create table coeff_langue_service (
     id serial primary key,
     id_poste integer,
     id_langue integer,
     note double precision not null,
     foreign key (id_poste) references poste (id),
     foreign key (id_langue) references langue (id)
);

create table coeff_experience_service (
    id serial primary key,
    id_poste integer,
    id_experience integer,
    note double precision not null,
    foreign key (id_poste) references poste (id),
    foreign key (id_experience) references experience (id)
);

create table cv (
    id serial primary key,
    id_poste integer,
    id_postulant integer,
    id_diplome integer,
    id_langue integer,
    id_experience integer,
    resident integer check (0 <= cv.resident <= 1),
    date date default current_date,
    foreign key (id_postulant) references postulant (id),
    foreign key (id_poste) references poste (id),
    foreign key (id_diplome) references diplome (id),
    foreign key (id_langue) references langue (id),
    foreign key (id_experience) references experience (id)
);

create view V_note_CV as
    select cv.id as idcv, cv.id_poste, c.note as diplome, c2.note as langue, c3.note as experience, (c.note + c2.note + c3.note ) as note from cv
        join coeff_diplome_service c on cv.id_diplome = c.id_diplome and cv.id_poste = c.id_poste
        join coeff_langue_service c2 on cv.id_langue = c2.id_langue and cv.id_poste = c2.id_poste
        join coeff_experience_service c3 on cv.id_experience = c3.id_experience and cv.id_poste = c3.id_poste
    order by note desc;

-- Reponse_test : misy FK Question
CREATE TABLE test (
    ID SERIAL PRIMARY KEY,
    ID_POSTE INTEGER,
    DATE_TEST DATE not null,
    foreign key (ID_POSTE) references poste (id)
);

create table question_test (
    id serial primary key,
    id_test integer,
    question varchar not null,
    coefficient integer check (0 < question_test.coefficient),
    foreign key (id_test) references test (id)
);

CREATE TABLE reponse_postulant (
    ID SERIAL PRIMARY KEY,
    ID_POSTULANT INTEGER,
    ID_QUESTION INTEGER,
    REPONSE DOUBLE PRECISION,
    FOREIGN KEY (ID_POSTULANT) REFERENCES postulant (ID),
    FOREIGN KEY (ID_QUESTION) REFERENCES question_test (ID)
);

create table back_office (
    id serial primary key,
    nom varchar not null,
    mdp varchar not null
);

CREATE TABLE accepte (
    ID SERIAL PRIMARY KEY,
    ID_POSTE INTEGER,
    ID_POSTULANT INTEGER,
    DATE_ACCEPTE DATE,
    etat integer not null check ( 0 <= accepte.etat <= 1 ),
    FOREIGN KEY (ID_POSTE) REFERENCES poste (ID),
    FOREIGN KEY (ID_POSTULANT) REFERENCES postulant (ID)
);

CREATE VIEW V_annonce AS SELECT p.NOM, exp.debut, exp.fin, l.NOM, d.NOM FROM critere_poste as c
    JOIN poste as p
       ON  c.ID_POSTE = p.ID
    JOIN experience as exp
       ON c.ID_EXPERIENCE = exp.ID
    JOIN langue as l
       ON c.ID_LANGUE = l.ID
    JOIN diplome as d
       ON c.ID_DIPLOME = d.ID;

create table annonce (
    id serial primary key,
    id_poste integer,
    date date default current_date,
    foreign key (id_poste) references poste(ID)
);

create table reponse_test (
    id serial primary key,
    id_question integer,
    reponse varchar not null,
    etat integer check ( 0 <= reponse_test.etat <= 1 ),
    foreign key (id_question) references question_test (id)
);

-- Entretien (Jérémie) : misy FK Poste sy date
CREATE TABLE postulant (
    ID SERIAL PRIMARY KEY,
    ID_POSTE INTEGER,
    NOM VARCHAR,
    PRENOM VARCHAR,
    DATE_NAISSANCE DATE,
    MAIL VARCHAR,
    MDP VARCHAR,
    FOREIGN KEY (ID_POSTE) REFERENCES poste (ID)
);

create table entretien (
    id serial primary key,
    id_poste integer,
    id_postulant integer,
    date date not null,
    foreign key (id_postulant) references postulant (id),
    foreign key (id_poste) references poste (id)
);

