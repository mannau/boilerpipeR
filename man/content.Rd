\docType{data}
\name{content}
\alias{content}
\title{Wordpress generated Webpage (retrieved from Quantivity Blog \url{http://quantivity.wordpress.com}).
Content is saved as character and ready to be extracted.}
\description{
  Wordpress generated Webpage (retrieved from Quantivity
  Blog \url{http://quantivity.wordpress.com}). Content is
  saved as character and ready to be extracted.
}
\examples{
#Data set has been generated as follows:
\dontrun{
library(RCurl)
url <- "http://quantivity.wordpress.com/2012/11/09/multi-asset-market-regimes/"
content <- getURL(url)
}
}
\author{
  Mario Annau
}
\references{
  \url{http://quantivity.wordpress.com}
}
\keyword{data}
\keyword{datasets}

