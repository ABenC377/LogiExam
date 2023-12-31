/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package com.cburch.logisim.std.gates;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.util.GraphicsUtil;

class OddParityGate extends AbstractGate {
	public static OddParityGate FACTORY = new OddParityGate();

	private OddParityGate() {
		super("Odd Parity", Strings.getter("oddParityComponent"));
		setRectangularLabel("2k+1");
		setIconNames("parityOddGate.gif");
	}

	@Override
	public void paintIconShaped(InstancePainter painter) {
		paintIconRectangular(painter);
	}
	
	@Override
	public void paintIconRectangular(InstancePainter painter) {
		Graphics g = painter.getGraphics();
		g.setColor(Color.black);
		g.drawRect(1, 2, 16, 16);
		Font old = g.getFont();
		g.setFont(old.deriveFont(9.0f));
		GraphicsUtil.drawCenteredText(g, "2k", 9,  6);
		GraphicsUtil.drawCenteredText(g, "+1", 9, 13);
		g.setFont(old);
	}

	@Override
	protected void paintShape(InstancePainter painter, int width, int height) {
		paintRectangular(painter, width, height);
	}

	@Override
	protected void paintDinShape(InstancePainter painter, int width, int height,
			int inputs) {
		paintRectangular(painter, width, height);
	}

	@Override
	protected Value computeOutput(Value[] inputs, int numInputs,
			InstanceState state) {
		return GateFunctions.computeOddParity(inputs, numInputs);
	}


	@Override
	protected Value getIdentity() { return Value.FALSE; }

}
