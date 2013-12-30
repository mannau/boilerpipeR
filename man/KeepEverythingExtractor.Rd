\name{KeepEverythingExtractor}
\alias{KeepEverythingExtractor}
\title{Marks everything as content.}
\usage{
  KeepEverythingExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
  extracted text as character
}
\description{
  Marks everything as content.
}
\examples{
data(content)
extract <- KeepEverythingExtractor(content)
}
\author{
  Mario Annau
}
\seealso{
  \code{\link{Extractor}}
}

