/**

 * <p>作者 Administrator</p>

 * <p>功能描述:</p>

 * <p>创建时间:20122012-2-2上午11:06:05</p>

 */





import java.io.DataInputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.io.PrintStream;

import java.net.InetAddress;

import java.net.ServerSocket;

import java.net.Socket;

/**

 * <p>作者 Administrator</p>

 * <p>功能描述:</p>

 * <p>创建时间:20122012-2-2上午11:06:05</p>

 */

/**

 * @author Administrator

 *

 */

public class ClientServer {

    public static void main(String[] args) {

        //服务器接口类

        ServerSocket sst=null;

        //套接口类

        Socket sc=null;



        InputStream is=null;

        OutputStream os=null;

        //dataInput为input的子类

        DataInputStream in=null;

        //printStream为output的子类

        PrintStream ps=null;

        try {

            //构造对象端口为8000

            sst =new ServerSocket(8000);

            //建立套接口

            sc=sst.accept();

            //获取套接口的输入流

            is=sc.getInputStream();

            //构造数据的输入流datainput对象in

            in=new DataInputStream(is);

            //获取套接口的输出流

            os=sc.getOutputStream();

            //构造数据的输出流PrintStream对象os

            ps=new PrintStream(os);

            //获取客户端的IP

            InetAddress Ip=sc.getInetAddress();

            //显示ip

            System.out.println("连接地址ip："+Ip);

            int port;

            port=sc.getPort();

            System.out.println("客户端端口"+port);

            ps.println("Welcome");

            //在in上读取一行

            String str=in.readLine();

            while(!str.equals("quit")){

                System.out.println("客户说："+str);

                str=in.readLine();

            }

            System.out.println("客户离开");





        } catch (IOException e) {

            e.printStackTrace();

        }finally{

            //关闭

            try {

                is.close();

                os.close();

                sc.close();

                System.exit(0);

            } catch (IOException e) {

                e.printStackTrace();

            }



        }

    }

}

