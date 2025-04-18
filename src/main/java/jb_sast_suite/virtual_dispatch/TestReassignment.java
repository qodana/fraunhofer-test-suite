// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.virtual_dispatch;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TestReassignment {
  public static void test(HttpServletRequest request, HttpServletResponse response, int x) throws IOException {
    String taint = request.getHeader("value");
    Base var1 = new Derived1();
    var1 = new Derived2();

    response.getWriter().println(var1.foo(taint));  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }

  static class Base {
    String foo(String str) {
      return "Base";
    }
  }

  static class Derived1 extends Base {
    @Override
    String foo(String str) {
      return "Derived1";
    }
  }

  static class Derived2 extends Base {
    @Override
    String foo(String str) {
      return str;
    }
  }
}
