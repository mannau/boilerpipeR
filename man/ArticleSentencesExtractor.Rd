\name{ArticleSentencesExtractor}
\alias{ArticleSentencesExtractor}
\title{A full-text extractor which is tuned towards extracting sentences from news articles.}
\usage{
  ArticleSentencesExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
  extracted text as character
}
\description{
  A full-text extractor which is tuned towards extracting
  sentences from news articles.
}
\examples{
data(content)
extract <- ArticleSentencesExtractor(content)
}
\author{
  Mario Annau
}
\seealso{
  \code{\link{Extractor}}
}

