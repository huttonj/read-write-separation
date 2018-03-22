package main.java.com.mhc.util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author maihe
 */
public class CollectionUtil {
    public static <K, T> Map<K, T> groupList2Map0(List<T> input, IMapGroup<K, T> i) {
        if (CollectionUtils.isEmpty(input)) {
            return null;
        }
        Map<K, T> map = Maps.newHashMap();
        input.forEach(entity -> {
            K key = i.getKey(entity);
            map.put(key, entity);
        });
        return map;
    }

    public static <K, T> Map<K, List<T>> groupList2Map(List<T> input, IMapGroup<K, T> i) {
        if (CollectionUtils.isEmpty(input)) {
            return null;
        }
        Map<K, List<T>> map = Maps.newHashMap();
        input.forEach(entity -> {
            K key = i.getKey(entity);
            if (map.get(key) == null) {
                List<T> list = Lists.newArrayList();
                list.add(entity);
                map.put(key, list);
            } else {
                map.get(key).add(entity);
            }
        });
        return map;
    }

    public static <V,E> List<V> beanToVarList(List<E> input, IMapGroup<V,E> i){
        if(CollectionUtils.isEmpty(input)){
            return null;
        }
        List<V> list = Lists.newArrayList();
        input.forEach(entity ->{
            V var = i.getKey(entity);
            list.add(var);
        });
        return list;
    }

    public interface IMapGroup<K, T> {
        K getKey(T t);
    }


    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("a");
        list.add("d");
        Map<String,String> map0 = CollectionUtil.groupList2Map0(list, e -> e);
        System.out.println(JSON.toJSONString(map0));
        Map<String,List<String>> map = CollectionUtil.groupList2Map(list,e -> e);
        System.out.println(JSON.toJSONString(map));

    }
}
