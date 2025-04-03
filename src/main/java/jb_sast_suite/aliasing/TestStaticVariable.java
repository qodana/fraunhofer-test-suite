// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.aliasing;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestStaticVariable {
  static String storage = "safe";

  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    response.getWriter().println(storage);
    storage = taint;
    response.getWriter().println(storage); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
