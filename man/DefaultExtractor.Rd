\name{DefaultExtractor}
\alias{DefaultExtractor}
\title{A quite generic full-text extractor.}
\usage{
DefaultExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
extracted text as character
}
\description{
A quite generic full-text extractor.
}
\examples{
data(content)
extract <- DefaultExtractor(content)
}
\author{
Mario Annau
}
\seealso{
\code{\link{Extractor}}
}

