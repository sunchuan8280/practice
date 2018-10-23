/*
 * package storm.bolt;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.apache.storm.task.OutputCollector; import
 * org.apache.storm.task.TopologyContext; import
 * org.apache.storm.topology.OutputFieldsDeclarer; import
 * org.apache.storm.topology.base.BaseRichBolt; import
 * org.apache.storm.tuple.Fields; import org.apache.storm.tuple.Tuple; import
 * org.apache.storm.tuple.Values;
 * 
 * public class WordCountBolt extends BaseRichBolt { private OutputCollector
 * collector; private Map<String, Long> counts = null;
 * 
 * public void execute(Tuple tuple) { String word =
 * tuple.getStringByField("word"); Long count = 0L; if
 * (counts.containsKey(word)) { count = counts.get(word); count++;
 * counts.put(word, count); } this.collector.emit(new Values(word, count)); }
 * 
 * public void prepare(Map arg0, TopologyContext arg1, OutputCollector
 * collector) { this.collector = collector; counts = new HashMap<String,
 * Long>(); }
 * 
 * public void declareOutputFields(OutputFieldsDeclarer declarer) {
 * declarer.declare(new Fields("word", "count")); }
 * 
 * }
 */