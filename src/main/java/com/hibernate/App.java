package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Alien telusko=new Alien(1,"Abhinav","Red");

        Configuration con=new Configuration();

        SessionFactory sf =con.buildSessionFactory();
        Session session=sf.openSession();
        session.save(telusko);

    }
}
