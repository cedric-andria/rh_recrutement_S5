/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author P14A-10-Cedric
 */
public class Postgresql extends URLConnection{
    public Postgresql(int port,String nombase){
        super("jdbc:postgresql://localhost:"+port+"/".concat(nombase),"org.postgresql.Driver");
    }
}
