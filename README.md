# boilerpipeR
<!-- badges: start -->
  [![R build status](https://github.com/mannau/boilerpipeR/workflows/R-CMD-check/badge.svg)](https://github.com/mannau/boilerpipeR/actions)
  <!-- badges: end -->

**boilerpipeR** is an R-package which provides an interface to [boilerpipe](http://code.google.com/p/boilerpipe/), a Java library written by Christian Kohlschütter [1]. It supports the generic extraction of main text content from HTML files and therefore removes ads, side-bars and headers from the HTML source content. The extraction heuristics from *boilerpipe* show a robust performance for a wide range of web site templates.


## Install
To install the [latest version from CRAN](http://cran.r-project.org/web/packages/boilerpipeR/index.html) simply 
```python
install.packages("boilerpipeR")
```

Using the **devtools** package you can easily install the latest development version of **boilerpipeR** from github with

```python
library(devtools)
install_github("mannau/boilerpipeR")
```

Windows users need to use the following command to install from github:

```python
library(devtools)
install_github("mannau/boilerpipeR", args = "--no-multiarch")
```

## Usage
To download and extract the main text from e.g. the R-Studio blog you can use the following commands:
```python
library(boilerpipeR)

url <- "http://blog.rstudio.org/2014/05/09/reshape2-1-4/"
maintext <- ArticleExtractor(url, asText = FALSE)
cat(maintext)
```

## References
[1] Christian Kohlschütter, [Exploiting Links and Text Structure on the Web — A Quantitative Approach to Improving Search Quality](http://www.kohlschutter.com/pdf/Dissertation-Kohlschuetter.pdf), PhD Thesis

## License
boilerpipe and **boilerpipeR** are both released under the [Apache Version 2 License](http://www.apache.org/licenses/LICENSE-2.0.html)


