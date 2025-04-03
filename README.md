# jb-sast-test-suite

## Usage notes
This project uses a standard pair of source+sink methods for testing tainted data propagation:
- `javax.servlet.http.HttpServletRequest.getHeader("value")` as a source;
- `javax.servlet.http.HttpServletResponse.getWriter().println()` as a sink.

In addition to this, the [`taint_sources`](/src/main/java/jb_sast_suite/taint_sources/) folder contains tests for different sources, currently just the `org.springframework.web.bind.annotation.RequestParam`-annotated parameters.

This project is not supposed to build because it contains files specifically designed to test static analysis in the presence of invalid code (see [`invalid_code`](/src/main/java/jb_sast_suite/invalid_code/) folder).

## License
Copyright 2025, JetBrains.

This work is licensed under [CC BY-NC-ND 4.0](https://creativecommons.org/licenses/by-nc-nd/4.0/). See complete license text in [LICENSE.md](/LICENSE.md).
