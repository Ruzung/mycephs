package com.ruzz.ceph;

import java.io.FileNotFoundException;

import com.ceph.fs.CephMount;
import com.ceph.rados.exceptions.RadosException;
import com.ceph.rbd.RbdException;

public class CephFsClient {

    public static void main(String[] args) throws RadosException, RbdException {
        // ceph 文件系统
        String[] listdir = null;
        try {
            CephMount cephMount = new CephMount("admin");
            cephMount.conf_read_file("/opt/ceph/ceph.conf");
            cephMount.mount("/");
            cephMount.chmod("/", 511);
            cephMount.mkdir("/test1234", 511);

            cephMount.chdir("/" + "test1234");

            cephMount.mkdir("retgsdf", 292);
            cephMount.chmod("/" + "test1234", 511);

            System.out.println("打印test1234下的所有目录");
            String[] listdir2 = cephMount.listdir("/" + "test1234");
            for (String strDir : listdir2) {
                System.out.println("dir:" + strDir);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String strDir : listdir) {
            System.out.println("dir:" + strDir);
        }

        // ceph 快设备
        // Rados cluster = new Rados("bar1");
        // File filePath = new File("/opt/ceph/ceph.conf");
        // try {
        // cluster.confReadFile(filePath);
        // } catch (RadosException e) {
        // e.printStackTrace();
        // }
        // cluster.connect();
        // IoCTX io = cluster.ioCtxCreate("rdb");
        //
        // Rbd rbd = new Rbd(io);
        // rbd.list();
        // rbd.open("myimages");
        // rbd.create("", 1);
        //

    }
}
