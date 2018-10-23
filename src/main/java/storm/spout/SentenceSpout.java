/*
 * import java.util.Map;
 * 
 * import org.apache.storm.spout.SpoutOutputCollector; import
 * org.apache.storm.task.TopologyContext; import
 * org.apache.storm.topology.OutputFieldsDeclarer; import
 * org.apache.storm.topology.base.BaseRichSpout; import
 * org.apache.storm.tuple.Fields; import org.apache.storm.tuple.Values;
 * 
 * import utils.Sleeputils;
 * 
 * public class SentenceSpout extends BaseRichSpout { private
 * SpoutOutputCollector collector; private String[] sentence = {
 * "my dog has fleas", "i like cole beverages", "the dog ate my homework",
 * "dont't have a cow man", "i don't think i lke fleas" }; private int index =
 * 0;
 * 
 * public void nextTuple() { this.collector.emit(new Values(sentence[index]));
 * index++; if (index >= sentence.length) { index = 0; } Sleeputils.second(1); }
 * 
 * public void open(Map map, TopologyContext context, SpoutOutputCollector
 * collector) { this.collector = collector; }
 * 
 * public void declareOutputFields(OutputFieldsDeclarer declarer) {
 * declarer.declare(new Fields("sentence")); }
 * 
 * }
 */