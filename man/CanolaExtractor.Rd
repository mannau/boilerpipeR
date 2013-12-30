\name{CanolaExtractor}
\alias{CanolaExtractor}
\title{A full-text extractor trained on a \href{http://krdwrd.org/}{krdwrd} \href{https://krdwrd.org/trac/attachment/wiki/Corpora/Canola/CANOLA.pdf}{Canola}.}
\usage{
  CanolaExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
  extracted text as character
}
\description{
  A full-text extractor trained on a
  \href{http://krdwrd.org/}{krdwrd}
  \href{https://krdwrd.org/trac/attachment/wiki/Corpora/Canola/CANOLA.pdf}{Canola}.
}
\examples{
data(content)
extract <- CanolaExtractor(content)
}
\author{
  Mario Annau
}
\seealso{
  \code{\link{Extractor}}
}

