package space.eh.stdecrypt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Dumper {

    private static FileOutputStream fstream;

    public Dumper(String filename) {
        try {
            fstream = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dumper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Dump byte array to a file
     *
     * @param dump byte array
     * @param filename
     */
    static void dump(byte[] dump, String filename) {
        if (dump == null) {
            return;
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(STDecrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fos.write(dump, 0, dump.length);
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(STDecrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void append(byte[] b) {
        try {
            fstream.write(b);
        } catch (IOException ex) {
            Logger.getLogger(Dumper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void close() {
        try {
            fstream.close();
        } catch (IOException ex) {
            Logger.getLogger(Dumper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
