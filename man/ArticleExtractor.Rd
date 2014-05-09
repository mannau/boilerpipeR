\name{ArticleExtractor}
\alias{ArticleExtractor}
\title{A full-text extractor which is tuned towards news articles.}
\usage{
ArticleExtractor(content, ...)
}
\arguments{
  \item{content}{Text content as character}

  \item{...}{additional parameters}
}
\value{
extracted text as character
}
\description{
In this scenario it achieves higher accuracy than
\code{\link{DefaultExtractor}}.
}
\examples{
data(content)
extract <- ArticleExtractor(content)
}
\author{
Mario Annau
}
\seealso{
\code{\link{Extractor}}
}

