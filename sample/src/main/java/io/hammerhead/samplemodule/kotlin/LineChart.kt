/**
 * Copyright (c) 2021 Hammerhead Navigation Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.hammerhead.samplemodule.kotlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Picture
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import io.hammerhead.sample.R

class LineChart(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var picture: Picture? = null
    private var linePath: Path? = null
    private var linePoints: List<Double>? = null
    private var scaleMatrix = Matrix()
    private var linePaint: Paint
    private var backgroundPaint: Paint

    init {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.LineChart,
                0, 0
        ).apply {
            linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                style = Paint.Style.STROKE
                color = getColor(R.styleable.LineChart_strokeColor, context.getColor(R.color.colorAccent))
                strokeCap = Paint.Cap.ROUND
                strokeWidth = getDimensionPixelSize(R.styleable.LineChart_strokeSize, 2).toFloat()
            }

            backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                style = Paint.Style.FILL
                color = getColor(R.styleable.LineChart_fillColor, context.getColor(R.color.transparent))
            }
        }
    }

    fun setStrokeColor(@ColorInt strokeColor: Int) {
        linePaint.color = strokeColor
        linePath = buildPath()
        updatePicture()
    }

    fun setStrokeSize(strokeSize: Float) {
        linePaint.strokeWidth = strokeSize
        linePath = buildPath()
        updatePicture()
    }

    fun setFillColor(@ColorInt fillColor: Int) {
        backgroundPaint.color = fillColor
        linePath = buildPath()
        updatePicture()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (oldw != w || oldh != h) {
            linePath = buildPath()
            updatePicture()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        picture?.apply { canvas.drawPicture(this) }
    }

    fun setPoints(points: List<Double>) {
        linePoints = points
        linePath = buildPath()
        updatePicture()
    }

    private fun buildPath(): Path? {
        return linePoints?.let { points ->
            val minValue = (points.min() ?: return null)
            val path = Path()
            path.moveTo(0f, 0f)
            points.forEachIndexed { index, point ->
                path.lineTo(index.toFloat(), (point - minValue).toFloat())
            }
            path.lineTo(points.lastIndex.toFloat(), 0f)
            path.close()

            val bounds = RectF()
            path.computeBounds(bounds, true)

            val maxValue = (points.max() ?: return null) - minValue
            val xScale = width.toFloat() / points.lastIndex
            val yScale = (height.toFloat() / maxValue.toFloat()) * -1
            scaleMatrix.setScale(xScale, yScale, 0f, 0f)
            scaleMatrix.postTranslate(0f, height.toFloat())
            path.transform(scaleMatrix)
            return path
        }
    }

    private fun updatePicture() {
        picture = Picture()
        picture?.apply {
            val canvas = beginRecording(measuredWidth, measuredHeight)
            linePath?.let {
                canvas.drawPath(it, linePaint)
                canvas.drawPath(it, backgroundPaint)
            }
            endRecording()
        }
        invalidate()
    }
}
