import base64

base64_cipher_bytes = b'GkUbFBoBDRIHEBgOQUUPExwDHEZYFx9XDg4EBBgFHQRTFwIURgcbFRwHBQQQEBQURgcOBxYQHBJT\nFwIURgsGAgsHDAgWW10TTUJPABoKAQQCUlVRDxZPQUNCTxQaW1dXCgcMRlVCTxMVVVpdFRFPQUNC\nTxIVUV0TTUJPBxYNT0FOFx9DCAxJRgQ='
key_bytes = b'abhaybhat784'

cipher_bytes = base64.b64decode(base64_cipher_bytes)
multiplier = len(cipher_bytes) // len(key_bytes) + 1

key_bytes *= multiplier
key_bytes = key_bytes[:len(cipher_bytes)]

cipher_int = int.from_bytes(cipher_bytes, 'big')
key_int = int.from_bytes(key_bytes, 'big')

plain_int = cipher_int ^ key_int
plain_bytes = plain_int.to_bytes(len(cipher_bytes), 'big')
plain = plain_bytes.decode('utf-8')
print(plain)