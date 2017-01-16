package com.mogproject.mogami.playground.view

/**
  * layout constants
  */
case class Layout(canvasWidth: Int, canvasHeight: Int) {

  // constants
  val PIECE_WIDTH = 34
  val PIECE_HEIGHT = 36
  val INDICATOR_HEIGHT = 10
  val HAND_UNIT_WIDTH = 43
  val BOARD_LEFT: Int = 2
  val BOARD_WIDTH: Int = PIECE_WIDTH * 9
  val BOARD_HEIGHT: Int = PIECE_HEIGHT * 9
  val PIECE_BOX_UNIT_WIDTH = 38

  // rectangles
  val handWhite = Rectangle(BOARD_LEFT, 2, BOARD_WIDTH, PIECE_HEIGHT)
  val indicatorWhite = Rectangle(BOARD_LEFT, handWhite.bottom + 2, BOARD_WIDTH, INDICATOR_HEIGHT)
  val board = Rectangle(BOARD_LEFT, indicatorWhite.bottom + 2, BOARD_WIDTH, BOARD_HEIGHT)
  val indicatorBlack = Rectangle(BOARD_LEFT, board.bottom + 2, BOARD_WIDTH, INDICATOR_HEIGHT)
  val handBlack = Rectangle(BOARD_LEFT, indicatorBlack.bottom + 2, BOARD_WIDTH, PIECE_HEIGHT)
  val fileIndex: Rectangle = indicatorWhite
  val rankIndex = Rectangle(board.right + 1, board.top, 12, BOARD_HEIGHT)
  val pieceBox = Rectangle(BOARD_LEFT, handBlack.bottom + 10, BOARD_WIDTH, PIECE_HEIGHT)

  // fonts
  object font {
    val pieceJapanese = """22pt "游明朝", YuMincho, "ヒラギノ明朝 ProN W3", "Hiragino Mincho ProN", "HG明朝E", "ＭＳ Ｐ明朝", "ＭＳ 明朝", serif"""
    val mark = """24pt "游明朝", YuMincho, "ヒラギノ明朝 ProN W3", "Hiragino Mincho ProN", "HG明朝E", "ＭＳ Ｐ明朝", "ＭＳ 明朝", serif"""
    val pieceEnglish = "18pt Times, serif"
    val number = "13pt Times, serif"
    val index = """8pt "游明朝", YuMincho, "ヒラギノ明朝 ProN W3", "Hiragino Mincho ProN", "HG明朝E", "ＭＳ Ｐ明朝", "ＭＳ 明朝", serif"""
  }

  // colors
  object color {
    val fg = "black"  // foreground
    val bg = "#fefdfa"  // background
    val red = "#b22222"  // promoted pieces
    val win = "#83ff9d"
    val lose = "#ff5843"
    val draw = "#99877a"
    val active = "#45A1CF"
    val cursor = "#E1B265"
    val dark = "#353535"
    val light = "#E0FFFF"
    val pieceBox = "#cccccc" // background of the piece box
  }
}
