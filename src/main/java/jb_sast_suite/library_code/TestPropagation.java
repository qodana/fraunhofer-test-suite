// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.library_code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class TestPropagation {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String str = Base64.getDecoder().decode(taint).toString();

    response.getWriter().println(str); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
