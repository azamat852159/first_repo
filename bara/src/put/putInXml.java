package put;

import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class putInXml {
    public static void main(String[] args) {

        String user = "weblogic";
        String password = "weblogic";
        String host = "k10-spm-app-1.msk.vtb24.ru";
        int port = 22;

        String remoteFile = "/u01/rsa/logs/gc_k10-spm-app-1.log";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Creating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            InputStream out = null;
            out = sftpChannel.get(remoteFile);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(out))) {
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
            }
        } catch (JSchException | SftpException | IOException e) {
            System.err.print(e);
        }
    }
}