package io.demo.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RandomImage")
public class RandomImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		setBackground(g);
		setBorder(g);
		drawRandomLine(g);
		drawRandomNumber(g);
		
		// pass image to browser
		response.setContentType("image/jpeg");
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	private void drawRandomNumber(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("", Font.BOLD, 20));
		
		for (int i = 0; i < 5; i++) {
			int degree = new Random().nextInt()%30; 	// can be +-
			g.rotate(degree*Math.PI/180, 24*i, HEIGHT);
			g.drawString(String.valueOf(new Random().nextInt(10)), 24*i+7, HEIGHT-7);
			g.rotate(-degree*Math.PI/180, 24*i, HEIGHT);
		}
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}

	private void setBackground(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GRAY);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
