package jh.ParkingService.servlet;

import jh.ParkingService.service.park.ParkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "parkDataSaveServlet", urlPatterns = "/lots/save")
public class ParkDataSaveServlet extends HttpServlet {

    @Autowired
    private ParkServiceImpl parkingService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        parkingService.saveData();

    }
}
