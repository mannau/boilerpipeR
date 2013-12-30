\name{LargestContentExtractor}
\alias{LargestContentExtractor}
\title{A full-text extractor which extracts the largest text component of a page.}
\usage{
  LargestContentExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
  extracted text as character
}
\description{
  For news articles, it may perform better than the
  \code{\link{DefaultExtractor}}, but usually worse than
  \code{\link{ArticleExtractor}}.
}
\examples{
data(content)
extract <- LargestContentExtractor(content)
}
\author{
  Mario Annau
}
\seealso{
  \code{\link{Extractor}}
}

