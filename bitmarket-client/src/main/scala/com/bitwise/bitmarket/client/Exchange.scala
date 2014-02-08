package com.bitwise.bitmarket.client

import com.google.bitcoin.core.{ECKey, NetworkParameters}

import scala.language.postfixOps

import com.bitwise.bitmarket.common.PeerConnection
import com.bitwise.bitmarket.common.currency.BtcAmount
import com.bitwise.bitmarket.common.currency.BtcAmount.Implicits._

case class Exchange(
    id: String,
    counterpart: PeerConnection,
    broker: PeerConnection,
    network: NetworkParameters,
    userKey: ECKey,
    counterpartKey: ECKey,
    exchangeAmount: BtcAmount,
    steps: Int,
    lockTime: Long) {
  require(steps > 0, "Steps must be greater than zero")
  require(exchangeAmount > (0 bitcoins), "Exchange amount must be greater than zero")
  require(userKey.getPrivKeyBytes != null, "Credentials do not contain private key")
}
