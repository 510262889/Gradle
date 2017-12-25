package com.main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class JettyServer {

    /*private String webAppDir;
    private int port;
    private String context;
    private boolean running = false;
    private Server server;
    private WebAppContext webApp;

    public JettyServer( String webAppDir, int port, String context ) {
        if ( webAppDir == null )
            throw new IllegalStateException( "Invalid webAppDir of web server." );
        if ( port < 0 || port > 65536 )
            throw new IllegalArgumentException( "Invalid port of web server: " + port );
        if ( context == null || "".equals( context.trim() ) )
            throw new IllegalStateException( "Invalid context of web server: " + context );

        this.webAppDir = webAppDir;
        this.port = port;
        this.context = context;
    }

    public void start() {
        if ( !running ) {
            try {doStart();} catch ( Exception e ) { e.printStackTrace();}
            running = true;
        }
    }

    public void stop() {
        if ( running ) {
            try {server.stop();} catch ( Exception e ) {e.printStackTrace();}
            running = false;
        }
    }

    private void doStart() {
        if ( !available( port ) )
            throw new IllegalStateException( "port: " + port + " already in use!" );

        server = new Server();
        Connector connector = getConnector();
        connector.setPort( port );
        server.addConnector( connector );
        webApp = new WebAppContext();
        webApp.setThrowUnavailableOnStartupException( true );    // 在启动过程中允许抛出异常终止启动并退出 JVM
        webApp.setContextPath( context );
        webApp.setResourceBase( webAppDir );    // webApp.setWar(webAppDir);
        webApp.setInitParameter( "org.eclipse.jetty.servlet.Default.dirAllowed", "false" );
        webApp.setInitParameter( "org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false" );    // webApp.setInitParams(Collections.singletonMap("org.mortbay.jetty.servlet.Default.useFileMappedBuffer", "false"));
        // 配置临时目录
        webApp.setAttribute("javax.servlet.context.tempdir", "build/scratchdir");
        // 配置jsp环境
        ServletHolder holderJsp = new ServletHolder( "jsp", JspServlet.class );
        holderJsp.setInitOrder( 0 );
        holderJsp.setInitParameter( "fork", "false" );
        holderJsp.setInitParameter( "logVerbosityLevel", "DEBUG" );
        holderJsp.setInitParameter( "scratchdir", "build/scratchdir/jsp" );
        holderJsp.setInitParameter( "xpoweredBy", "false" );
        holderJsp.setInitParameter( "suppressSmap", "true" );
        holderJsp.setInitParameter( "keepgenerated", "true" );
        holderJsp.setInitParameter( "compilerTargetVM", "1.7" );
        holderJsp.setInitParameter( "compilerSourceVM", "1.7" );

        webApp.addServlet( holderJsp, "*.jsp" );
        server.setHandler( webApp );

        try {
            System.out.println( "Starting web server on port: " + port );
            server.start();
            System.out.println( "Starting Complete." );
            server.join();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit( 100 );
        }
    }

    protected Connector getConnector() {
        return new SelectChannelConnector();
    }

    private static boolean available( int port ) {
        if ( port <= 0 ) {
            throw new IllegalArgumentException( "Invalid start port: " + port );
        }

        ServerSocket ss = null;
        DatagramSocket ds = null;
        try {
            ss = new ServerSocket( port );
            ss.setReuseAddress( true );
            ds = new DatagramSocket( port );
            ds.setReuseAddress( true );
            return true;
        } catch ( IOException ignored ) {

        } finally {
            if ( ds != null ) {
                ds.close();
            }

            if ( ss != null ) {
                try {
                    ss.close();
                } catch ( IOException ignored ) {

                }
            }
        }
        return false;
    }*/
}
