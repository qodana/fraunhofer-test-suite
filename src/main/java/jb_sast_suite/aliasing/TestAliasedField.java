// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.aliasing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestAliasedField {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    A x = new A();
    A y = x;
    response.getWriter().println(x.a);
    y.a = taint;
    response.getWriter().println(x.a); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }

  class A {
    public String a;
  }
}
