// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.virtual_dispatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestUnknownValue {
  public static void test(HttpServletRequest request, HttpServletResponse response, Base var1)
    throws IOException {
    String taint = request.getHeader("value");
    response.getWriter().println(var1.foo(taint)); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }

  class Base {
    String foo(String str) {
      return "Base";
    }
  }

  class Derived1 extends Base {
    @Override
    String foo(String str) {
      return "Derived1";
    }
  }

  class Derived2 extends Base {
    @Override
    String foo(String str) {
      return str;
    }
  }
}
