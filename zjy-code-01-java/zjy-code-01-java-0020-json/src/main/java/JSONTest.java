import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/22
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class JSONTest {
    public static void main(String[] args) {
   /*     String jsonStr = "{\"rows\": [{\"ID\": \"5E4BC31D5EC84A3B8901404D7EAC9F70\",\"STUDYID\": \"1606300286\",\"JCHZ\": \"1. 一般项目结论： 未见异常 2. 心电室结论： 正常心电图 3. 彩超一结论： 未见异常 4. 放射检查结论：1.颈椎骨质未见明显异常，生理曲度变直。 2.两肺及心膈未见明显异常。 5. C-14结论： 检测结果：DPM= 0 阴性 - 6. 血常规(5分类) (1) 血小板偏高：407.00↑ (*10^9/L) (2)红细胞压积偏低：34.60↓ (%) (3) 平均红细胞体积偏低：76.90↓ (fL) (4) 平均血红蛋白量偏低：\\n\",\"ZJJL\": \"1. 颈椎生理曲度变直 2. 血小板增多症 3. 乙肝表面抗体阳性 4. 总胆固醇增\",\"JLRQ\": \"2016-06-30 15:34:16\",\"JLYS\": \"刘博\",\"YLJY\":\"1. 颈椎生理曲度变直： 正常颈椎凸面向前轻度弯曲，曲度变直可产生压迫症状，压迫颈部血管可致眩晕等症状，压迫臂丛神经可致颈肩，臂疼痛，手发麻等。 建议 (1)避免长时间低头工作； (2)避免高枕；枕头宜与拳头高。 (3)适当颈椎抬头后仰活动。 2. 血小板增多症： 血小板计数超过400×10*9/L为血小板增多症 正常午后、冬季、高原居民、妊娠中晚期、剧烈活动和饱餐后可轻度升高。 （1）见于骨髓增殖性疾病（如真性红细胞增多症和原发性血小板增多症、骨髓纤维化早期、慢性粒细胞白血病等）。 \",\"ROW_ID\": 1}],\"total\": 1}";


        final JSONObject jsonObject = JSON.parseObject(jsonStr);
        final String rows = jsonObject.getString("rows");
        final JSONArray objects = JSON.parseArray(rows);
        for (Object object : objects) {
            System.out.println(JSON.parseObject(object.toString()).get("JCHZ"));
        }*/
//        System.out.println(rows);


        String str2 = "1. 一般项目结论： 未见异常 \\n2. 心电室结论： 正常心电图 \\n3. 彩超一结论： 未见异常 \n4. 放射检查结论：\n\t1.颈椎骨质未见明显异常，生理曲度变直。\n" +
                "\t 2.两肺及心膈未见明显异常。 \n5. C-14结论： 检测结果：DPM= 0 阴性 - \n6. 血常规(5分类) \n\t(1) 血小板偏高：407.00↑ (*10^9/L) \n" +
                "\t(2)红细胞压积偏低：34.60↓ (%) \n" +
                "\t(3) 平均红细胞体积偏低：76.90↓ (fL) \n" +
                "\t(4) 平均血红蛋白量偏低：";

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("JCHZ", str2);
        System.out.println(jsonObject1);
    }
}
