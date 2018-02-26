package crypto

import scorex.crypto.signatures.Signature

object Curve25519SignatureForger {

    def forgeSignature(signature: Signature): Signature = {
        val modif: BigInt = BigInt("7237005577332262213973186563042994240857116359379907606001950938285454250989")
        Signature @@ (signature.take(32) ++ (BigInt(signature.takeRight(32).reverse) + modif).toByteArray.reverse)
    }

}
