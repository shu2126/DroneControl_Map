/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE SERVO_OUTPUT_RAW PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.
*/
public class msg_servo_output_raw_test{

public static final int MAVLINK_MSG_ID_SERVO_OUTPUT_RAW = 36;
public static final int MAVLINK_MSG_LENGTH = 21;
private static final long serialVersionUID = MAVLINK_MSG_ID_SERVO_OUTPUT_RAW;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_SERVO_OUTPUT_RAW);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_SERVO_OUTPUT_RAW); //msg id
    payload.putInt((int)963497464); //time_usec
    payload.putShort((short)17443); //servo1_raw
    payload.putShort((short)17547); //servo2_raw
    payload.putShort((short)17651); //servo3_raw
    payload.putShort((short)17755); //servo4_raw
    payload.putShort((short)17859); //servo5_raw
    payload.putShort((short)17963); //servo6_raw
    payload.putShort((short)18067); //servo7_raw
    payload.putShort((short)18171); //servo8_raw
    payload.put((byte)65); //port
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_servo_output_raw", processedPacket, packet);
}
}
        