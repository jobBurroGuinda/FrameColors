
import java.awt.*
import java.awt.event.AdjustmentEvent
import java.awt.event.AdjustmentListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener

class FrameColors : Frame(), WindowListener, AdjustmentListener {
    var chkGrayScale: Checkbox
    var midPanel: Panel
    var redBar: Scrollbar
    var blueBar: Scrollbar
    var greenBar: Scrollbar

    private fun setGrayScale(GrayScaleValue: Int) {
        greenBar.value = GrayScaleValue
        redBar.value = GrayScaleValue
        blueBar.value = GrayScaleValue
    }

    override fun windowOpened(e: WindowEvent) {}
    override fun windowClosed(e: WindowEvent) {}
    override fun windowIconified(e: WindowEvent) {}
    override fun windowDeiconified(e: WindowEvent) {}
    override fun windowActivated(e: WindowEvent) {}
    override fun windowDeactivated(e: WindowEvent) {}
    override fun windowClosing(e: WindowEvent) {
        dispose()
    }

    override fun adjustmentValueChanged(e: AdjustmentEvent) {
        //8.1: Initialize RGB Components
        var red: Int
        var blue: Int
        var green: Int
        blue = 0
        green = blue
        red = green

        if (e.adjustable === redBar) {
            red = redBar.value
            if (chkGrayScale.state) {
                green = red
                blue = green
                setGrayScale(red)
            }
        }
        if (e.adjustable === blueBar) {
            blue = blueBar.value
            if (chkGrayScale.state) {
                red = blue
                green = red
                setGrayScale(blue)
            }
        }
        if (e.adjustable === greenBar) {
            green = greenBar.value
            if (chkGrayScale.state) {
                blue = green
                red = blue
                setGrayScale(green)
            }
        }

        val rgbColor = Color(red, green, blue)
        midPanel.background = rgbColor
        title = "Red: $red Green: $green Blue: $blue   ::   Job Adolfo Salinas Hernández"
    }

    init {
        addWindowListener(this)
        val topPanel = Panel()
        midPanel = Panel()
        redBar = Scrollbar(Scrollbar.HORIZONTAL, 0, 5, 0, 255)
        redBar.background = Color.RED
        blueBar = Scrollbar(Scrollbar.HORIZONTAL, 0, 5, 0, 255)
        blueBar.background = Color.BLUE
        greenBar = Scrollbar(Scrollbar.HORIZONTAL, 0, 5, 0, 255)
        greenBar.background = Color.GREEN
        redBar.blockIncrement = 5
        blueBar.blockIncrement = 5
        greenBar.blockIncrement = 5

        topPanel.layout = GridLayout(3, 1)
        topPanel.add(redBar)
        topPanel.add(blueBar)
        topPanel.add(greenBar)

        chkGrayScale = Checkbox("Escala de Grises")
        add(BorderLayout.SOUTH, chkGrayScale)
        add(BorderLayout.NORTH, topPanel)
        add(midPanel)

        redBar.addAdjustmentListener(this)
        blueBar.addAdjustmentListener(this)
        greenBar.addAdjustmentListener(this)
        title = "Job Adolfo Salinas Hernández"
    }

    fun displayFrame(){
        preferredSize = Dimension(500, 500)
        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }

}

fun main() {
    val frame = FrameColors()
    frame.displayFrame()
}