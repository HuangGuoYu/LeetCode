package test;

import entity.Event;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by AXT on 2018/1/8.
 */
public class EventManager {
    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        mgr.createAndStoreEvent("My Event", new Date());
        GetSeesionFactory.getSessionFactory().close();
    }
    private void createAndStoreEvent(String title, Date theDate) {
        Session session = GetSeesionFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
        session.getTransaction().commit();
    }
}
