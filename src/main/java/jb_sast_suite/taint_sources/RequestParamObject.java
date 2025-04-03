// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.taint_sources;

import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestParamObject extends HttpServlet {
  public void test(@RequestParam UserData taint, HttpServletResponse response) throws IOException {
    response.getWriter().println(taint.value);  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }

  class UserData {
    public String value;
  }
}
