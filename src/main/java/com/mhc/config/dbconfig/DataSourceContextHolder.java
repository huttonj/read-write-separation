package main.java.com.mhc.config.dbconfig;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地线程，数据源上下文
 * @author maihe
 *
 */
@Slf4j
public class DataSourceContextHolder {
    /**
     * 标示当前线程读写类型
     */
	private static final ThreadLocal<String> local = new ThreadLocal<>();

    /**
     * 读库
     */
    public static void setRead() {
        log.info("数据库切换到读库...");
        local.set(DataSourceType.READ.getType());
    }

    /**
     * 写库
     */
    public static void setWrite() {
        log.info("数据库切换到写库...");
        local.set(DataSourceType.WRITE.getType());
    }

    public static String getReadOrWrite() {
        return local.get();
    }

    /**
     * 读写类型擦除
     */
    public static void erase(){
    	local.remove();
    }
}
