// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.arithmetic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestDivisionByZero {
  public static void test(HttpServletRequest request, HttpServletResponse response, boolean condition) throws IOException {
    String taint = request.getHeader("value");

    int x = 1/0;
    response.getWriter().println(taint);
  }
}