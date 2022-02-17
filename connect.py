import helper.adb as adb

try:
    ip_address = adb.get_ip()
    adb.connect_wifi(ip_address)
    print("device connected to Wi-Fi with ip/port {}:5555".format(ip_address))
except:
    print("Could not connect via Wi-Fi")
