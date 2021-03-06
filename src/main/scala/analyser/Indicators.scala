package analyser

import cats.implicits._
import analyser.model.{Indicator, IndicatorType, IndicatorValue, StockMarketEntry}

object Indicators {

  def computeSimpleMovingAverage(indicatorType: IndicatorType, data: Vector[StockMarketEntry]): Option[Indicator] = {
    if (data.length === indicatorType.periodSpan) {
      val indicator = Indicator(
        indicatorType = indicatorType,
        indicatorValue = IndicatorValue(data.map(_.close.value).sum / indicatorType.periodSpan)
      )
      Some(indicator)
    } else {
      None
    }
  }
}
