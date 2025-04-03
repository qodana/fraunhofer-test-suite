// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package fraunhofer_suite.library_code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestBasic {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String[] arr = taint.split(":");

    response.getWriter().println(arr[0]); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
