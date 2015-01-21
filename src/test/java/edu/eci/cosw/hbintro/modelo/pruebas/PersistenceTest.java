/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.hbintro.modelo.pruebas;

import edu.eci.cosw.hbintro.modelo.Producto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
/**
 *
 * @author hcadavid
 */
public class PersistenceTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;
    
    /**
     * Operaciones que se realizan antes de ejecutar el banco de pruebas.
     * En este caso se crea una misma sesión que será usada en todas las
     * pruebas.
     */
    @Before
    public void setupSession() {
        
        Configuration configuration = new Configuration();
        //configuration.configure("hibernate.cfg.xml");
        /**
         * PARA LAS PRUEBAS SE USA UNA BASE DE DATOS H2 EN MEMORIA
         */
        configuration.configure("hibernate-inmemory.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
        configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        
    }
        
    /**
     * Operaciones que se realizan cuando finalice la ejecución de las pruebas.
     * En este caso se cierra la sesi_n y la f_brica de sesiones.
     */
    @After
    public void closeResources(){
        session.close();
        sessionFactory.close();
    }
 
    /**
     * El objetivo de esta prueba es que el mapeo permita hacer persistentes
     * productos, y luego consultar de forma consistente los mismos
     * Estado inicial: base de datos vacía.
     * Prueba: La consulta de la sumatora del precio de los productos debe
     * ser consistente con los precios de los productos ingresados.
     * 
     */
    @Test
    public void productPersistenceTest(){
        Transaction tx=session.beginTransaction();
        Producto p=new Producto("Producto prueba 1",222);
        session.save(p);
        p=new Producto("Producto prueba 2",222);
        session.save(p);

        Query q=session.createQuery("select sum(precio) from Producto");
        List<Long> res=q.list();
        
        Assert.assertEquals("La prueba de consultar"
                + " la suma de los precios de los"
                + " productos no da un resultado"
                + " consistente.", res.get(0),new Long(444));
        
        tx.commit();        
    }
    
    
    
}
