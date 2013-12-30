\name{NumWordsRulesExtractor}
\alias{NumWordsRulesExtractor}
\title{A quite generic full-text extractor solely based upon the number of words per block (the current, the previous and the next block).}
\usage{
  NumWordsRulesExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
  extracted text as character
}
\description{
  A quite generic full-text extractor solely based upon the
  number of words per block (the current, the previous and
  the next block).
}
\examples{
data(content)
extract <- NumWordsRulesExtractor(content)
}
\author{
  Mario Annau
}
\seealso{
  \code{\link{Extractor}}
}

