\name{Extractor}
\alias{Extractor}
\title{Generic extraction function which calls boilerpipe extractors}
\usage{
Extractor(exname, content, asText = TRUE, ...)
}
\arguments{
  \item{exname}{character specifying the extractor to be
  used. It can take one of the following values: \itemize{
  \item{\code{\link{ArticleExtractor}}}{A full-text
  extractor which is tuned towards news articles.}
  \item{\code{\link{ArticleSentencesExtractor}}}{A
  full-text extractor which is tuned towards extracting
  sentences from news articles.}
  \item{\code{\link{CanolaExtractor}}}{A full-text
  extractor trained on a
  \href{http://krdwrd.org/}{krdwrd}.}
  \item{\code{\link{DefaultExtractor}}}{A quite generic
  full-text extractor.}
  \item{\code{\link{KeepEverythingExtractor}}}{Marks
  everything as content.}
  \item{\code{\link{LargestContentExtractor}}}{A full-text
  extractor which extracts the largest text component of a
  page.} \item{\code{\link{NumWordsRulesExtractor}}}{A
  quite generic full-text extractor solely based upon the
  number of words per block.} }}

  \item{content}{Text content or URL as character}

  \item{asText}{should content specifed be treated as
  actual text to be extracted or url (from which HTML
  document is first downloaded and extracted afterwards),
  defaults to TRUE}

  \item{...}{additional parameters}
}
\value{
extracted text as character
}
\description{
It is the actual workhorse which directly calls the
boilerpipe Java library. Typically called through functions
as listed for parameter \code{exname}.
}
\author{
Mario Annau
}
\references{
\url{http://code.google.com/p/boilerpipe/}
}

