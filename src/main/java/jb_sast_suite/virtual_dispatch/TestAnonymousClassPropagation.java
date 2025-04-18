// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.virtual_dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class TestAnonymousClassPropagation {
  public static void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    Base base = new Base().createAnonymous(taint);
    response.getWriter().println(base.getValue()); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    response.getWriter().println(base.value);
  }
  static class Base {
    String value = "";
    public String getValue() {
      return value;
    }
    public Base createAnonymous(String taint) {
      return new Base() {
        String value = taint;
        @Override
        public String getValue() {
          return taint;
        }
      };
    }
  }
}
