package java_chobo2.ch16.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	public void start() throws IOException {
		DatagramSocket datagranSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

		byte[] msg = new byte[100];

		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

		datagranSocket.send(outPacket);
		datagranSocket.receive(inPacket);

		System.out.println("current sever time : " + new String(inPacket.getData()));

		datagranSocket.close();
	}

	public static void main(String[] args) {
		try {
			new UdpClient().start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
