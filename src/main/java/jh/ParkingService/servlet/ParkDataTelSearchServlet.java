package jh.ParkingService.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jh.ParkingService.domain.park.Park;
import jh.ParkingService.service.park.ParkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "parkDataTelSerachSevlet", urlPatterns = "/lots/tel")
public class ParkDataTelSearchServlet extends HttpServlet {

    @Autowired
    private ParkServiceImpl parkingService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String num = request.getParameter("num");
        System.out.println("num = " + num);

        List<Park> parkList = parkingService.searchTel(num);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<String> parkJsonList = new ArrayList<>();

        //objectMapper 로 'park(자바객체형태)' -> 'Json 형태'-> 'Json 구문의 String 형태' 순으로 변환하여 String 변수에 저장
        //그리고 String List 인 parkJsonList 에 값 저장
        for (Park park : parkList) {
            String parkJson = objectMapper.writeValueAsString(park);
            parkJsonList.add(parkJson);
        }

        //저장한 parkJsonList 를 클라이언트에게 전달
        out.print(parkJsonList);
        out.flush();

    }
}
