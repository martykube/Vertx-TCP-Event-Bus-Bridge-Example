#!/usr/bin/python

import socket
import json
import struct


# connect to bridge
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect(('localhost', 15651))
print 'Connected'

# send ping
message = json.dumps({'type': 'ping'})
packed_message = struct.pack('!i%ss' % len(message), len(message), message)
sock.sendall(packed_message)
print 'Ping sent'


# send register
message = json.dumps({'type': 'register', 'address': 'pcs.status', 'headers': {}, 'body':{}})
packed_message = struct.pack('!i%ss' % len(message), len(message), message)
sock.sendall(packed_message)
print 'Register sent'


# Try to read a message
len_str = sock.recv(4)
len = struct.unpack("!i", len_str)[0]
print len
payload = sock.recv(len)
print payload
