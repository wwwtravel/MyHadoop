package cn.uc.hadoop.mapreduce.lib.partition;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparator;

public class ReverseTextSortComparator extends WritableComparator implements
		Configurable {
	protected ReverseTextSortComparator() {
		super(Text.class);
	}
	private Configuration conf;
	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public Configuration getConf() {
		return conf;
	}

	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		int t = Text.Comparator.compareBytes(b1, s1, l1, b2, s2, l2);
		return -t;
	}

	// @Override
	public int compare(Text o1, Text o2) {
		return -(o1.compareTo(o2));
	}
}