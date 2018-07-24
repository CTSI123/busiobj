package cn.com.ctsi.busiobj.util;

import cn.com.ctsi.busiobj.bean.base.FilePiece;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;


public class FileSpliteUtil {

    public static int MB_SIZE = 1024 * 1024;
    public static int LIMIT_SIZE = MB_SIZE;
    public static final String basePath=new File("").getAbsolutePath();
    public static final String fileTempSavePath=basePath.substring(0, basePath.lastIndexOf(File.separator) + 1) + "fileUpload";//上传文件临时存储的路径


    public static final String FILE_PIECE_PATH =
            new File("").getAbsolutePath() +File.separator+ "/fileSplite";

    /**
     * 文件分割
     *
     * @param
     */
    public static void split(File file) {
        clearChild(file);
        int number = calculateFilePiece(file);
        String fileName = file.getName(); // 源文件名
        InputStream in = null; // 输入字节流
        BufferedInputStream bis = null; // 输入缓冲流
        byte[] bytes = new byte[1024 * 1024]; // 每次读取文件的大小为1MB
        int len = -1; // 每次读取的长度值
        try {
            in = new FileInputStream(file);
            bis = new BufferedInputStream(in);
            for (int i = 0; i < number; i++) {
                String destName = FILE_PIECE_PATH + File.separator + fileName + "-" + i + ".dat";
                OutputStream out = new FileOutputStream(destName);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int count = 0;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len); // 把字节数据写入目标文件中
                    count += len;
                    if (count >= LIMIT_SIZE) {
                        break;
                    }
                }
                bos.flush(); // 刷新
                bos.close();
                out.close();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (bis != null) bis.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }





    private static void clearChild(File f) {

        new File(FILE_PIECE_PATH).mkdir();
        File files = new File(FILE_PIECE_PATH);
        if (files.isDirectory() && files.length() > 0) {
            for (File file : files.listFiles()) {
                file.delete();
            }
        }
    }


    /**
     * 计算文件分片
     *
     * @param
     * @return
     */
    public static int calculateFilePiece(File file) {
        int piece = (int) (file.length() / LIMIT_SIZE);
        piece = file.length() % LIMIT_SIZE == 0 ? piece : piece + 1; // 分割后文件的数目
        return piece;
    }

    public static ArrayList<FilePiece> cutDownFile(File file) {
        int MB_SIZE = 1024 * 1024;
        int LIMIT_SIZE = MB_SIZE;
        int count=calculateFilePiece(file);
        ArrayList<FilePiece> list = new ArrayList<>();
        long i = 0;
        int index = 0;
        while (i < file.length()) {
            long start = i;
            long end;
            if (i + LIMIT_SIZE <file.length()) {
                end = i + LIMIT_SIZE;
            } else {
                end = file.length();
            }
            index++;
            String piecePath = FILE_PIECE_PATH + File.separator + file.getName()+ "-" + i + ".dat";
            FilePiece piece=new FilePiece(count,piecePath,start,end,index);
            i += LIMIT_SIZE;
            list.add(piece);
        }
        return list;
    }



    public static File fileSave(MultipartFile file) throws Exception {
        File uploadDir=new File(fileTempSavePath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        File f = null;
        if (!(file.equals("") || file.getSize() <= 0)){
            InputStream ins = file.getInputStream();
            f = new File(fileTempSavePath + File.separator + file.getOriginalFilename());
            if(!f.exists()){
                inputStreamToFile(ins, f);
            }
        }
        return f;
    }


    public static void clearFileTempSavePath(){
        File file=new File(fileTempSavePath);
        for(File f:file.listFiles()){
            if(f.exists()){
                Boolean isDel=f.delete();
                if (!isDel){
                    LogUtil.logError("从文件暂存地址中删除文件失败，文件为："+f,FileSpliteUtil.class);
                }else{
                    LogUtil.logInfo("从文件暂存地址中删除文件成功，文件为："+f,null,FileSpliteUtil.class);
                }
            }
        }
    }


    public static void inputStreamToFile(InputStream ins,File file){
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
