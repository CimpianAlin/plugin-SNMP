package plugins.SNMP.snmplib;

import freenet.config.Config;
import freenet.io.comm.IOStatisticCollector;
import freenet.node.Node;

/**
 * @author cyberdo
 *
 * Creates the SNMP-agent
 */
public class SNMPStarter {

	private static boolean has_been_runned = false;

	public static void initialize() {
		//SNMPAgent.setSNMPPort(port);
		if (has_been_runned) return;
		// 0 is toatl I/O
		for (int i = 0 ; i < IOStatisticCollector.STATISTICS_ENTRIES ; i++) {
			SNMPAgent.getSNMPAgent().addFetcher(new DataStatisticsInfo(i, true));
			SNMPAgent.getSNMPAgent().addFetcher(new DataStatisticsInfo(i, false));
		}
		SNMPAgent.getSNMPAgent().addFetcher(new InfoSystem());
		
		has_been_runned = true;
	}

	public static void maybeCreate(Node node, Config config) {
		// FIXME any config needed for SNMPStarter?
	}
}
