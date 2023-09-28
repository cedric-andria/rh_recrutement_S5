-- Table Responsable_service (Jérémie) : misy FK Service sy identifiant de connexion
create table responsable (
    id serial primary key,
    nom varchar not null,
    mdp varchar not null
);

create table service (
    id serial primary key
);

create table responsable_service (
  id serial primary key,
  id_service integer,
  id_responsable integer,
  foreign key (id_service) references service (id),
  foreign key (id_responsable) references responsable (id)
);

-- CritèresPoste (Jérémie) : misy FK Poste
create table poste (
    id serial primary key,
    id_service integer,
    foreign key (id_service) references service(id)
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
    id_service integer,
    id_diplome integer,
    id_langue integer,
    id_experience integer,
    foreign key (id_poste) references poste (id),
    foreign key (id_service) references service (id),
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
    id_service integer,
    note double precision not null,
    foreign key (id_poste) references poste (id),
    foreign key (id_diplome) references diplome (id),
    foreign key (id_service) references service (id)
);

create table coeff_langue_service (
     id serial primary key,
     id_poste integer,
     id_langue integer,
     id_service integer,
     note double precision not null,
     foreign key (id_poste) references poste (id),
     foreign key (id_langue) references langue (id),
     foreign key (id_service) references service (id)
);

create table coeff_experience_service (
    id serial primary key,
    id_poste integer,
    id_experience integer,
    id_service integer,
    note double precision not null,
    foreign key (id_poste) references poste (id),
    foreign key (id_experience) references experience (id),
    foreign key (id_service) references service (id)
);

create table cv (
    id serial primary key,
    id_poste integer,
    id_service integer,
    id_diplome integer,
    id_langue integer,
    id_experience integer,
    foreign key (id_poste) references poste (id),
    foreign key (id_service) references service (id),
    foreign key (id_diplome) references diplome (id),
    foreign key (id_langue) references langue (id),
    foreign key (id_experience) references experience (id)
);

create view V_note_CV as
    select cv.id as idcv, cv.id_poste, cv.id as id_service, c.note as diplome, c2.note as langue, c3.note as experience, (c.note + c2.note + c3.note ) as note from cv
        join coeff_diplome_service c on cv.id_diplome = c.id_diplome and cv.id_service = c.id_service and cv.id_poste = c.id_poste
        join coeff_langue_service c2 on cv.id_langue = c2.id_langue and cv.id_service = c2.id_service and cv.id_poste = c2.id_poste
        join coeff_experience_service c3 on cv.id_experience = c3.id_experience and  cv.id_service = c3.id_service and cv.id_poste = c3.id_poste
    order by note desc;

-- Reponse_test : misy FK Question
create table question (
    id serial primary key
);

create table reponse_test (
    id serial primary key,
    id_question integer,
    reponse varchar not null,
    foreign key (id_question) references question (id)
);

-- Entretien (Jérémie) : misy FK Poste sy date
create table postulant (
    id serial primary key
);

create table entretien (
    id serial primary key,
    id_poste integer,
    id_postulant integer,
    date date not null,
    foreign key (id_postulant) references postulant (id),
    foreign key (id_poste) references poste (id)
);
